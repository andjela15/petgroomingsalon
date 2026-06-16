const API_URL = "http://localhost:8080/api/termini";

let editingId = null;

document.addEventListener("DOMContentLoaded", loadTermini);

async function loadTermini() {
    const response = await fetch(API_URL);
    const termini = await response.json();

    const tbody = document.getElementById("termini-tbody");
    tbody.innerHTML = "";

    termini.forEach(termin => {
        tbody.innerHTML += `
            <tr>
                <td>${termin.terminId}</td>
                <td>${formatDateTime(termin.datumVreme)}</td>
                <td>${termin.usluga}</td>
                <td>${termin.status}</td>
                <td>${termin.napomena || ""}</td>
                <td>${termin.ljubimacId}</td>
                <td>
                    <button class="btn-edit" onclick="editTermin(${termin.terminId})">Izmeni</button>
                    <button class="btn-delete" onclick="deleteTermin(${termin.terminId})">Obriši</button>
                </td>
            </tr>
        `;
    });
}

async function saveTermin() {
    const termin = {
        datumVreme: document.getElementById("datumVreme").value,
        usluga: document.getElementById("usluga").value,
        status: document.getElementById("status").value,
        napomena: document.getElementById("napomena").value,
        ljubimacId: Number(document.getElementById("ljubimacId").value)
    };

    const url = editingId ? `${API_URL}/${editingId}` : API_URL;
    const method = editingId ? "PUT" : "POST";

    await fetch(url, {
        method: method,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(termin)
    });

    resetForm();
    loadTermini();
}

async function editTermin(id) {
    const response = await fetch(`${API_URL}/${id}`);
    const termin = await response.json();

    editingId = id;

    document.getElementById("terminId").value = termin.terminId;
    document.getElementById("datumVreme").value = formatForInput(termin.datumVreme);
    document.getElementById("usluga").value = termin.usluga;
    document.getElementById("status").value = termin.status;
    document.getElementById("napomena").value = termin.napomena || "";
    document.getElementById("ljubimacId").value = termin.ljubimacId;

    document.getElementById("saveBtn").textContent = "Izmeni termin";
    window.scrollTo({ top: 0, behavior: "smooth" });
}

async function deleteTermin(id) {
    if (!confirm("Da li ste sigurni da želite da obrišete termin?")) {
        return;
    }

    await fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    });

    loadTermini();
}

function resetForm() {
    editingId = null;

    document.getElementById("terminId").value = "";
    document.getElementById("datumVreme").value = "";
    document.getElementById("usluga").value = "";
    document.getElementById("status").value = "";
    document.getElementById("napomena").value = "";
    document.getElementById("ljubimacId").value = "";

    document.getElementById("saveBtn").textContent = "Sačuvaj termin";
}

function formatDateTime(value) {
    if (!value) {
        return "";
    }

    return new Date(value).toLocaleString("sr-RS");
}

function formatForInput(value) {
    if (!value) {
        return "";
    }

    return value.substring(0, 16);
}
