// forms.js
//


const init = function () {
    document.getElementById('button-cancel').addEventListener('click', reset);
    document.getElementById('button-send').addEventListener('click', send);
    // document.getElementById('input-fornavn').addEventListener('keyup', entersend(event))
        var inputfornavn = document.getElementById('input-fornavn');
        inputfornavn.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            send();
        };
    })
    var inputefternavn = document.getElementById('input-efternavn');
    inputefternavn.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            send();
        };
    })
    var inputfødselsdato = document.getElementById('input-fødselsdato');
    inputfødselsdato.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            send();
        };
    })
    var inputadresse = document.getElementById('input-adresse');
    inputadresse.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            send();
        };
    })
    var inputpostnummer = document.getElementById('input-postnummer');
    inputpostnummer.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            send();
        };
    })
    var inputby = document.getElementById('input-by');
    inputby.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            send();
        };
    })
    var inputtelefonnummer = document.getElementById('input-telefonnummer');
    inputtelefonnummer.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            send();
        };
    })
    var inputemail = document.getElementById('input-email');
    inputemail.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            send();
        };
    })
}

function entersend(event) {
    if (event.key === 13) {
        event.preventDefault;
        send();
    }
};

const reset = function (ev) {
    ev.preventDefault();
    document.getElementById('form-user').reset();
}

const send = function (ev) {
    ev.preventDefault();
    ev.stopPropagation();
    let fails = validate();
    if (fails.length === 0) {
        fetch("/send?q="
        +document.getElementById('input-fornavn').value
        +"="+document.getElementById('input-efternavn').value
        +"="+document.getElementById('input-fødselsdag').value
        +"="+document.getElementById('input-adresse').value
        +"="+document.getElementById('input-postnummer').value
        +"="+document.getElementById('input-by').value
        +"="+document.getElementById('input-indmeldingsdato').value
        +"="+document.getElementById('input-telefonnummer').value
        +"="+document.getElementById('input-email').value)
        .then(response => response.json());
    } else {
        fails.forEach(function(obj){
            let field = document.getElementById(obj.input);
            field.parentElement.classList.add('error');
            field.parentElement.setAttribute('data-errormsg', obj.msg);
        })
    }
}

const validate = function (ev) {
    let failures = [];

    let fornavn = document.getElementById('input-fornavn');
    if (fornavn.value === "") {
        failures.push({ input: 'input-fornavn', msg: 'Udfyld venligst fornavn' })
    }
    let efternavn = document.getElementById('input-efternavn');
    if (efternavn.value === "") {
        failures.push({ input: 'input-efternavn', msg: 'Udfyld venligst efternavn' })
    }
    let fødselsdato = document.getElementById('input-fødselsdato');
    if (fødselsdato.value === "") {
        failures.push({ input: 'input-fødselsdato', msg: 'Udfyld venligst fødselsdato' })
    }
    let adresse = document.getElementById('input-adresse');
    if (adresse.value === "") {
        failures.push({ input: 'input-adresse', msg: 'Udfyld venligst adresse' })
    }
    let postnummer = document.getElementById('input-postnummer');
    if (postnummer.value === "") {
        failures.push({ input: 'input-postnummer', msg: 'Udfyld venligst postnummer' })
    }
    let by = document.getElementById('input-by');
    if (by.value === "") {
        failures.push({ input: 'input-by', msg: 'Udfyld venligst by' })
    }
    let telefonnummer = document.getElementById('input-telefonnummer');
    if (telefonnummer.value === "") {
        failures.push({ input: 'input-telefonnummer', msg: 'Udfyld venligst telefonnummer' })
    }
    let email = document.getElementById('input-email');
    if (email.value === "") {
        failures.push({ input: 'input-email', msg: 'Udfyld venligst E-mail' })
    }

    return failures;
}


document.addEventListener('DOMContentLoaded', init);