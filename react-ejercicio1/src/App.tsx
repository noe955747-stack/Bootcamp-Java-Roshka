import ListaInteractiva from "./componentes/ListaInteractiva";
import type {objeto} from "./types/objeto";

const items: objeto[] = [
    { id: 1,
      label: "Alaska",
      children: [
          {id: 11, label: "Bascom"},
      ]
    },
    { id: 2, label: "Connecticut" },
    { id: 3,
      label: "Wisconsin",
      children:[
          {id: 31, label:"Oretta"},
          {id: 32, label:"Konterra"},
          {id: 33, label:"Guthrie"}
      ]
    },
    {
        id: 4,
        label: "Nebraska",
        children: [
            { id: 41, label: "Jennings" },
            { id: 42, label: "Harviel" },
            { id: 43, label: "Alfarata" },
            { id: 44, label: "Bluffview" },
            { id: 45, label: "Bluffview" }
        ]
    },
    {id:5, label:"Georgia"}
];

function App() {
    return (
        <div className={"cuerpo"}>
            <ListaInteractiva items={items} />
        </div>
    );
}

export default App;