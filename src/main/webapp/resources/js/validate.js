function validateFind() {
    str = document.getElementById('find').value;
    if(str.trim() === ""){
        alert("Введите условие поиска...");
        return false;
    }
    return true;
}

function validateValues() {
    photoValues = document.getElementById('photoValues').value;
    if(photoValues.trim() === ""){
        alert("Введите показания ...");
        return false;
    }
    if(document.getElementById("photoValuesDataPhoto").files.length == 0){
        alert("Добавьте фото ...");
        return false;
    }
    return true;
}

function validateValuesDataPhoto() {
    str = document.getElementById('valuesDataPhoto').value;
    if(str.trim() === ""){
        alert("Введите показания ...");
        return false;
    }
    if( document.getElementById("photoValuesDataPhoto").files.length == 0){
        alert("Добавьте фото ...");
        return false;
    }
    return true;
}