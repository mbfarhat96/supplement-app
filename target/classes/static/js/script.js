document.addEventListener('DOMContentLoaded', () => {
    const initialData = {
        name: document.getElementById('supplementName').innerText,
        description: document.getElementById('supplementDescription').innerText,
        benefits: document.getElementById('supplementBenefits').innerText,
        evidence: document.getElementById('supplementEvidence').innerText
    }
    updatePage(initialData); 
});

// 2. Function to Update Page Content
function updatePage(data) {
    document.getElementById('supplementName').textContent = data.name;
    document.getElementById('supplementDescription').textContent = data.description;
    document.getElementById('supplementBenefits').textContent = data.benefits;
    document.getElementById('supplementEvidence').textContent = data.evidence;
    console.log("Updating");
}

// 3. AJAX Search (on Form Submit)
const searchForm = document.querySelector('.supplementSearch');
searchForm.addEventListener('submit', (event) => {
    event.preventDefault(); // Stop the normal form submission

    const supplementName = searchForm.querySelector('input[name="name"]').value;

    fetch('/supplement-details?name=' + supplementName)
        .then(response => response.json()) // Get JSON data
        .then(data => {
            updatePage(data);
            document.getElementById('searchError').innerText = "";
        })   // Update page with new data
        .catch(error => {
            document.getElementById('searchError').innerText = "Invalid supplement name";
            console.error('Error fetching supplement details:', error); 
        });
});
