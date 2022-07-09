import "./App.css";
import axios from "axios";
import { useEffect, useState } from "react";

function App() {
  const [files, setFiles] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/file-list").then((response) => {
      setFiles(response.data);
    });
  }, []);

  return (
    <div className="App">
      <form
        method="post"
        action="http://localhost:8080/file-save"
        encType="multipart/form-data"
      >
        <input type="file" name="file" />
        <br />
        <input type="submit" />
      </form>
      <div>
        {files.length !== 0 &&
          files.map((file) => (
            <li>
              <a href={`http://localhost:8080/file-download/${file.id}`}>
                {file.originalFileName}
              </a>
            </li>
          ))}
      </div>
    </div>
  );
}

export default App;
