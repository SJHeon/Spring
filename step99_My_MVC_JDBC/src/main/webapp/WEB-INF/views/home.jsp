<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
session="false" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <h1>DB Page</h1>
    <hr />

    <h3>CREATE</h3>
    <input id="deptno1" type="text" placeholder="deptno" />
    <input id="dname" type="text" placeholder="dname" />
    <input id="loc" type="text" placeholder="loc" />
    <input type="button" value="click" onclick="insertDeptByDeptno()" />
    <script>
      const deptno1 = document.getElementById("deptno1");
      const dname = document.getElementById("dname");
      const loc = document.getElementById("loc");
      function insertDeptByDeptno() {
        axios
          .post(
            "http://localhost:8080/jdbc/api/insertDept",
            { deptno: deptno1.value, dname: dname.value, loc: loc.value },
            { headers: { "Content-Type": `application/json` } }
          )
          .then((res) => console.log(res));
      }
    </script>
    <hr />

    <h3>READ</h3>
    <input
      type="button"
      value="selectAllDepts"
      onclick="selectAllDept()"
    /><br />
    <input id="deptno2" type="text" placeholder="deptno" />
    <input type="button" value="click" onclick="selectDept()" />
    <script>
      const deptno2 = document.getElementById("deptno2");
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
          });
      }

      function selectDept() {
        console.log(deptno2.value);
        axios
          .get("http://localhost:8080/jdbc/api/dept/" + deptno2.value)
          .then((res) => {
            console.log(res.data);
            res.data;
            document.getElementById("result").innerHTML =
              "deptno : " +
              res.data.deptno +
              " " +
              "dname : " +
              res.data.dname +
              " " +
              "loc : " +
              res.data.loc;
          });
      }
    </script>
    <hr />

    <h3>UPDATE</h3>
    <input type="button" value="click" />
    <hr />
    <h3>DELETE</h3>
    <input type="button" value="click" />
    <hr />
    <h3>RESULT</h3>
    <div id="result"></div>
  </body>
</html>
