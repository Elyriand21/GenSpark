const form = document.querySelector('#student-registration-form');
const firstNameInput = document.querySelector('#fname');
const lastNameInput = document.querySelector('#lname');
const ageInput = document.querySelector('#age');
const addressInput = document.querySelector('#add');
const originInput = document.querySelector('#origin');

form.addEventListener("submit", (e) => {

    let isFirstNameValid = checkFirstName(),
    isLastNameValid = checkLastName(),
    isAgeValid = checkAge(),
    isOriginValid = checkOrigin();

    let isFormValid = isFirstNameValid &&
    isLastNameValid &&
    isAgeValid &&
    isOriginValid;

    if(isFormValid == true){
        form.submit();
    }
    else{
        e.preventDefault();
    }
})

function setError(element, errorMessage) {
    const parent = element.parentElement;
    parent.classList.remove('success');
    parent.classList.add('error');

    const errorInfo = parent.querySelector('small');

    errorInfo.textContent = errorMessage;
}

function setSuccess(element) {
    const parent = element.parentElement;
    parent.classList.remove('error');
    parent.classList.add('success');

    const errorInfo = parent.querySelector('small');
    errorInfo.textContent = '';
}

const checkFirstName = () => {
    const firstName = firstNameInput.value;

    let valid = false;
    if (/^[a-zA-Z]+$/.test(firstName)) {
        setSuccess(firstNameInput);
        valid = true;
    }
    else{
        setError(firstNameInput, "Please enter only letters");
    }
    return valid;
}

const checkLastName = () => {
    const lastName = lastNameInput.value;

    let valid = false;
    if (/^[a-zA-Z]+$/.test(lastName)) {
        setSuccess(lastNameInput);
        valid = true;
    }
    else{
        setError(lastNameInput, "Please enter only letters")
    }

    return valid;
}



const checkAge = () => {
    const age = ageInput.value;

    let valid = false;
    if (age > 0 && age < 100) {
        setSuccess(ageInput);
        valid = true;
    }
    return valid;
}

const checkOrigin = () => {
    const origin = originInput.value;

    let valid = false;
    if(/^[a-zA-Z]+$/.test(origin)){
        setSuccess(originInput);
        valid = true;
    }
    else{
        setError(originInput, "Please enter only letters");
    }

    return valid;
}