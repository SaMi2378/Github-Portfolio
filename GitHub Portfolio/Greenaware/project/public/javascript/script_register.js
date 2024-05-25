function toggleFields() {
    const category = document.getElementById('category').value;
    const observerFields = document.getElementById('observer-fields');

    if (category === 'Observer') {
        observerFields.style.display = 'block';
    } else {
        observerFields.style.display = 'none';
    }
}