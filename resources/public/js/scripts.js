function toggleFormPanel() {
    const drawer = document.getElementById('form-panel');
    drawer.open = !drawer.open;
}

document.addEventListener("toggleFormPanel", toggleFormPanel);
document.addEventListener("dishCreated", toggleFormPanel);
