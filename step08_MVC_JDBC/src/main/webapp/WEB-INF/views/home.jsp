<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
session="false" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <h1>¿DB?</h1>

    <script>
      //   (JSON) INSERT "/api/deptjson" => deptno : 90, dname : FRONTEND, loc : JEJU
      // axios
      //   .post(
      //     "http://localhost:8080/jdbc/api/deptjson",
      //     { deptno: 90, dname: "FRONTEND", loc: "JEJU" },
      //     { headers: { "Content-Type": `application/json` } }
      //   )
      //   .then((response) => console.log(response));

      // (FormEncoded) INSERT "/api/deptjson" => deptno : 100, dname : TEST, loc : TEST

      //   const formData = new URLSearchParams();
      //   formData.append("deptno", 100);
      //   formData.append("dname", "TEST");
      //   formData.append("loc", "TEST");
      //   axios
      //     .post(
      //       "http://localhost:8080/jdbc/api/deptform",
      //     //   "deptno=100&dname=TEST&loc=TEST",
      // 		formData,
      //       { headers: { "Content-Type": `application/x-www-form-urlencoded` } }
      //     )
      //     .then((response) => console.log(response));

      function selectAllDept() {
        axios
          .get("http://localhost:8080/jdbc/api/getDepts")
          .then((response) => response.data)
          .then((data) => {
            console.log(data);
            data.forEach((element) => {
              console.log(element);
              console.log(typeof element);
              document.getElementById("result").innerHTML +=
                // JSON.stringify(element);
                "deptno : " +
                element.deptno +
                " " +
                "dname : " +
                element.dname +
                " " +
                "loc : " +
                element.loc +
                "<br/>";
            });
            console.log("------------");
          });
      }
    </script>
    <hr />
    <P> selectAll </P>
    <input type="button" value="selectAllDepts" onclick="selectAllDept()" />
    <div id="result"></div>
  </body>
</html>
