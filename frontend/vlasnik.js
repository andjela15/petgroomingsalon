const API_URL = "http://localhost:8080/api/vlasnici";

let editingId = null;

document.addEventListener("DOMContentLoaded", loadVlasnici);

async function loadVlasnici() {
    const response = await fetch(API_URL);
    const vlasnici = await response.json();

    const tbody = document.getElementById("vlasnici-tbody");
    tbody.innerHTML = "";

    vlasnici.forEach(vlasnik => {
        tbody.innerHTML += `
            <tr>
                <td>${vlasnik.vlasnikId}</td>
                <td>${vlasnik.ime}</td>
                <td>${vlasnik.prezime}</td>
                <td>${vlasnik.telefon || ""}</td>
                <td>${vlasnik.email || ""}</td>
                <td>
                    <button class="btn-edit" onclick="editVlasnik(${vlasnik.vlasnikId})">Izmeni</button>
                    <button class="btn-delete" onclick="deleteVlasnik(${vlasnik.vlasnikId})">Obriši</button>
                </td>
            </tr>
        `;
    });
}

async function saveVlasnik() {
    const vlasnik = {
        ime: document.getElementById("ime").value,
        prezime: document.getElementById("prezime").value,
        telefon: document.getElementById("telefon").value,
        email: document.getElementById("email").value
    };

    const url = editingId ? `${API_URL}/${editingId}` : API_URL;
    const method = editingId ? "PUT" : "POST";

    await fetch(url, {
        method: method,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(vlasnik)
    });

    resetForm();
    loadVlasnici();
}

async function editVlasnik(id) {
    const response = await fetch(`${API_URL}/${id}`);
    const vlasnik = await response.json();

    editingId = id;

    document.getElementById("vlasnikId").value = vlasnik.vlasnikId;
    document.getElementById("ime").value = vlasnik.ime;
    document.getElementById("prezime").value = vlasnik.prezime;
    document.getElementById("telefon").value = vlasnik.telefon || "";
    document.getElementById("email").value = vlasnik.email || "";

    document.getElementById("saveBtn").textContent = "Izmeni vlasnika";
    window.scrollTo({ top: 0, behavior: "smooth" });
}

async function deleteVlasnik(id) {
    if (!confirm("Da li ste sigurni da želite da obrišete vlasnika?")) {
        return;
    }

    await fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    });

    loadVlasnici();
}

function resetForm() {
    editingId = null;

    document.getElementById("vlasnikId").value = "";
    document.getElementById("ime").value = "";
    document.getElementById("prezime").value = "";
    document.getElementById("telefon").value = "";
    document.getElementById("email").value = "";

    document.getElementById("saveBtn").textContent = "Sačuvaj vlasnika";
}
