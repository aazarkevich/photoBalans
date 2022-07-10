function validateFind() {
    str = document.getElementById('find').value;
    if(str.trim() === ""){
        alert("Введите условие поиска...");
        return false;
    }
    return true;
}

function validateValues() {
    values = document.getElementById("values").value;
    if(values.trim() === ""){
        alert("Введите показания values...");
        return false;
    }
    if(document.getElementById("photoValues").files.length == 0){
        alert("Добавьте фото values ...");
        return false;
    }
    return true;
}

function validateValuesDataPhoto() {
    valuesDataPhoto = document.getElementById('valuesDataPhoto').value;
    if(valuesDataPhoto.trim() === ""){
        alert("Введите показания ...");
        return false;
    }
    if( document.getElementById("photoValuesDataPhoto").files.length == 0){
        alert("Добавьте фото ...");
        return false;
    }
    return true;
}