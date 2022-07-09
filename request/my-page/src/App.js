import { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";
import Posts from "./Posts";
import Pagination from "./Pagination";

function App() {
  const [posts, setPosts] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [postsPerPage, setPostPerPage] = useState(10);

  useEffect(() => {
    const data = async () => {
      const response = await axios.get(
        "https://jsonplaceholder.typicode.com/posts"
      );
      setPosts(response.data);
    };
    data();
  }, []);

  // 현재 페이지
  // size
  // 총 데이터의 개수
  // 끝 페이지

  const lastPage = currentPage * postsPerPage;
  const firstPage = lastPage - postsPerPage;
  const currentData = (posts) => {
    let currentData = 0;
    currentData = posts.slice(firstPage, lastPage);
    return currentData;
  };

  return (
    <div className="App">
      {/* <Posts posts={posts} /> */}
      <Posts posts={currentData(posts)} />
      <Pagination
        postsPerPage={postsPerPage}
        totalPosts={posts.length}
        setCurrentPage={setCurrentPage}
      />
    </div>
  );
}

export default App;
