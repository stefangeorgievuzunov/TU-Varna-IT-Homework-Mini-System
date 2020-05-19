function personal(userId) {
    let name = document.getElementById("name");
    let job = document.getElementById("job");
    let description = document.getElementById("desc");

    const data={
        id:userId,
        name:name.value,
        job:job.value,
        description:description.value
    }

    postData("/fetch/personal",data);
}

function contacts(userId) {
    let phoneNumber=document.getElementById("phoneNumber");
    let city=document.getElementById("city");
    let street=document.getElementById("street");

    console.log(phoneNumber+" "+city);

    const data={
        id:userId,
        phoneNumber:phoneNumber.value,
        address: {
            city:city.value,
            street:street.value
        }
    }

    console.log(data);

    postData("/fetch/contacts",data);
}

function skills(userId) {
    let programmingSkillNames = document.getElementsByName("programmingSkillNames[]");
    let programmingSkillValues = document.getElementsByName("programmingSkillValues[]");

    let socialSkillNames = document.getElementsByName("socialSkillNames[]");
    let socialSkillValue = document.getElementsByName("socialSkillValues[]");

    let progSkills = [];
    let socSkills = [];

    for (let i = 0; i < programmingSkillNames.length; i++) {
        let name = programmingSkillNames[i];
        let value = programmingSkillValues[i];

        if (name.value !== "Умение") {
            progSkills.push({
                name: name.value,
                value: value.value
            })
        }
    }

    for (let i = 0; i < socialSkillNames.length; i++) {
        let name = socialSkillNames[i];
        let value = socialSkillValue[i];

        if (name.value !== "Умение") {
            socSkills.push({
                name: name.value,
                value: value.value
            })
        }
    }

    const data = {
        id: userId,
        socialSkills: socSkills,
        programmingSkills: progSkills
    }

   postData("/fetch/skills",data);
}


async function postData(url = '', data) {
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then((json) => {
        console.log(json.json());
    });
}



