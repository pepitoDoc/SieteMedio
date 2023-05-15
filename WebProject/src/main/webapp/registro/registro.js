window.addEventListener(
  "DOMContentLoaded",
  () => {
    document.querySelector("#botonRegistro").addEventListener(
      "click",
      (e) => {
        const nameInput = document.querySelector("#nickname").value;
        const passwordInput = document.querySelector("#password").value;
        if (nameInput != "" && passwordInput != "") {
            if (passwordInput.indexOf(" ") !== -1 || nameInput.indexOf(" ") !== -1) {
                alert("La contraseña y el nombre no pueden tener espacios");
            } else {
              const userData = {
                nickname: nameInput,
                password: passwordInput
              };
              fetch("http://localhost:8080/WebProject/add-user", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(userData)
              })
                .then((response) => response.text())
                .then((data) => {
                  if (data == "1") {
                    alert("Ya existe un usuario con ese nombre");
                  } else {
                    alert("Usuario registrado");
                    window.location.replace("http://localhost:8080/WebProject/index.jsp");
                  }
                })
                .catch((error) => {
                  console.error(error);
                });
            }
        } else {
          alert("No puede haber campos en blanco");
        }
      },
      false
    );
  },
  false
);
