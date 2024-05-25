// Function to show/hide additional fields based on category selection
function toggleFields() {
    const category = document.getElementById('category').value;
    const observerFields = document.getElementById('observer-fields');

    if (category === 'Observer') {
        observerFields.style.display = 'block';
    } else {
        observerFields.style.display = 'none';
    }
}


async function fetchUserDetails(userId) {
if (!userId) {
    return;
}

try {
    const response = await fetch(`/users/${userId}`);
    if (response.ok) {
        const user = await response.json();
        document.getElementById('email').value = user.email || '';
        document.getElementById('usertitle').value = user.usertitle || 'Mr';
        document.getElementById('userforename').value = user.userforename || '';
        document.getElementById('usersurname').value = user.usersurname || '';
        document.getElementById('mobileNumber').value = user.mobileNumber || '';
        document.getElementById('address').value = user.address || '';
        document.getElementById('country').value = user.country || '';
        document.getElementById('userDOB').value = user.userDOB ? new Date(user.userDOB).toISOString().split('T')[0] : '';
        document.getElementById('userAccounts').value = user.userAccounts || 1;
        document.getElementById('category').value = user.category || 'Support';
        document.getElementById('accountStatus').value = user.accountStatus || 'Active';

        if (user.category === 'Observer') {
            document.getElementById('observer-fields').style.display = 'block';
            document.getElementById('accountBalance').value = user.accountBalance || '';
            document.getElementById('cardnumber').value = user.cardnumber || '';
            document.getElementById('cardType').value = user.cardType || 'Visa';
            document.getElementById('cvv').value = user.cvv || '';
            document.getElementById('notificationPreference').value = user.notificationPreference || 'Text';
        } else {
            document.getElementById('observer-fields').style.display = 'none';
        }
    } else {
        console.error('Failed to fetch user details');
    }
} catch (error) {
    console.error('Error fetching user details:', error);
}
}

document.addEventListener('DOMContentLoaded', () => {
const userSelect = document.querySelector('select[name="_id"]');
userSelect.addEventListener('change', (event) => {
    fetchUserDetails(event.target.value);
});
});
