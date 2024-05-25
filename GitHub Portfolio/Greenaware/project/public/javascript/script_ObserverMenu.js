document.addEventListener('DOMContentLoaded', function () {
    const deleteButton = document.getElementById('deleteButton');
    const observationCheckboxes = document.querySelectorAll('.observationCheckbox');

    deleteButton.addEventListener('click', async function () {
        const selectedObservations = Array.from(observationCheckboxes)
            .filter(checkbox => checkbox.checked)
            .map(checkbox => checkbox.value);

        if (selectedObservations.length === 0) {
            alert('Please select observations to delete.');
            return;
        }

        const confirmation = confirm(`Are you sure you want to delete ${selectedObservations.length} observation(s)?`);
        if (!confirmation) return;

        console.log('Selected Observations:', selectedObservations); // Log selected observation IDs for debugging

        try {
            const response = await fetch('/observer/delete-observations', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json' // Ensure this is set correctly
                },
                body: JSON.stringify({ observations: selectedObservations }) // Stringify the body
            });

            if (response.ok) {
                alert('Selected observations deleted successfully.');
                // You can refresh the page or update the UI as needed
                window.location.reload();
            } else {
                const errorData = await response.json();
                throw new Error(errorData.message);
            }
        } catch (error) {
            console.error('Error:', error.message);
            alert('An error occurred while deleting observations. Please try again.');
        }
    });
});
