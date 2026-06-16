const API_URL = "http://localhost:8080/api/ljubimci";

let editingId = null;

document.addEventListener("DOMContentLoaded", loadLjubimci);

async function loadLjubimci() {
    const response = await fetch(API_URL);
    const ljubimci = await response.json();

    const tbody = document.getElementById("ljubimci-tbody");
    tbody.innerHTML = "";

    ljubimci.forEach(ljubimac => {
        tbody.innerHTML += `
            <tr>
                <td>${ljubimac.ljubimacId}</td>
                <td>${ljubimac.ime}</td>
                <td>${ljubimac.vrsta}</td>
                <td>${ljubimac.rasa || ""}</td>
                <td>${ljubimac.starost || ""}</td>
                <td>${ljubimac.vlasnikId}</td>
                <td>
                    <button class="btn-edit" onclick="editLjubimac(${ljubimac.ljubimacId})">Izmeni</button>
                    <button class="btn-delete" onclick="deleteLjubimac(${ljubimac.ljubimacId})">Obriši</button>
                </td>
            </tr>
        `;
    });
}

async function saveLjubimac() {
    const ljubimac = {
        ime: document.getElementById("ime").value,
        vrsta: document.getElementById("vrsta").value,
        rasa: document.getElementById("rasa").value,
        starost: Number(document.getElementById("starost").value),
        vlasnikId: Number(document.getElementById("vlasnikId").value)
    };

    const url = editingId ? `${API_URL}/${editingId}` : API_URL;
    const method = editingId ? "PUT" : "POST";

    await fetch(url, {
        method: method,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(ljubimac)
    });

    resetForm();
    loadLjubimci();
}

async function editLjubimac(id) {
    const response = await fetch(`${API_URL}/${id}`);
    const ljubimac = await response.json();

    editingId = id;

    document.getElementById("ljubimacId").value = ljubimac.ljubimacId;
    document.getElementById("ime").value = ljubimac.ime;
    document.getElementById("vrsta").value = ljubimac.vrsta;
    document.getElementById("rasa").value = ljubimac.rasa || "";
    document.getElementById("starost").value = ljubimac.starost || "";
    document.getElementById("vlasnikId").value = ljubimac.vlasnikId;

    document.getElementById("saveBtn").textContent = "Izmeni ljubimca";
    window.scrollTo({ top: 0, behavior: "smooth" });
}

async function deleteLjubimac(id) {
    if (!confirm("Da li ste sigurni da želite da obrišete ljubimca?")) {
        return;
    }

    await fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    });

    loadLjubimci();
}

function resetForm() {
    editingId = null;

    document.getElementById("ljubimacId").value = "";
    document.getElementById("ime").value = "";
    document.getElementById("vrsta").value = "";
    document.getElementById("rasa").value = "";
    document.getElementById("starost").value = "";
    document.getElementById("vlasnikId").value = "";

    document.getElementById("saveBtn").textContent = "Sačuvaj ljubimca";
}