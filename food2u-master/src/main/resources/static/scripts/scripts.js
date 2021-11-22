
let password1 = document.getElementById("inputPassword1");
let password2 = document.getElementById("inputPassword2");

let signupForm = document.getElementById("sign-up");

signupForm.addEventListener("submit", function (event) {
    let password1Value = password1.value;
    let password2Value = password2.value;

    if (password2Value != password1Value) {
        event.preventDefault();
        password2.setCustomValidity("Both passwords must match.");
        password2.reportValidity();
    } else {
        password2.setCustomValidity("");
    }
});

password1.addEventListener("input", function (event) {
    if (password1.validity.patternMismatch) {
        password1.setCustomValidity("Must be atleast 8 characters, contain 1 uppercase letter, 1 lowercase letter, 1 symbol, and 1 number");
        password1.reportValidity();
    } else {
        password1.setCustomValidity("");
        password1.reportValidity();
    }
});

