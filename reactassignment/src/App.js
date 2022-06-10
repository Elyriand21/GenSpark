import Title from "./Components/Title"
import Bio from "./Components/Bio"
import Projects from "./Components/Projects";

function App() {
  return (
    <div>
      <Title />
    <div className="container" stlye={{"display": "flex","border":"1px solid black"}}>
      <Bio /> <Projects />
    </div>
    </div>
  );
}

export default App;
