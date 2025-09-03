import './stylesheets/App.css'
import type {Item} from "./types/objeto";
import ListaInteractiva from "./componentes/ListaInteractiva.tsx";
import BarraNav from "./componentes/BarraNav.tsx";

const items1 : Item[] =[
    {
        id:1,
        label:"Holdback",
        descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultrices eros vel blandit egestas. Suspendisse purus libero, blandit vel ante non, tincidunt elementum justo. Vestibulum non ornare dui. Morbi eget lorem et ligula consectetur ullamcorper vel sollicitudin dui. Suspendisse potenti. Integer laoreet est est, ut tincidunt purus interdum id. Praesent non urna ante. Quisque ligula eros, pulvinar pulvinar pharetra at, semper id enim."
    },
    {
        id:2,
        label:"Financial Assurance",
        descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultrices eros vel blandit egestas. Suspendisse purus libero, blandit vel ante non, tincidunt elementum justo. Vestibulum non ornare dui. Morbi eget lorem et ligula consectetur ullamcorper vel sollicitudin dui. Suspendisse potenti. Integer laoreet est est, ut tincidunt purus interdum id. Praesent non urna ante. Quisque ligula eros, pulvinar pulvinar pharetra at, semper id enim."
    },
    {
        id:3,
        label:"Liability Ringfencing",
        descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultrices eros vel blandit egestas. Suspendisse purus libero, blandit vel ante non, tincidunt elementum justo. Vestibulum non ornare dui. Morbi eget lorem et ligula consectetur ullamcorper vel sollicitudin dui. Suspendisse potenti. Integer laoreet est est, ut tincidunt purus interdum id. Praesent non urna ante. Quisque ligula eros, pulvinar pulvinar pharetra at, semper id enim."
    },
    {
        id:4,
        label:"ARO Creditor Rights",
        descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultrices eros vel blandit egestas. Suspendisse purus libero, blandit vel ante non, tincidunt elementum justo. Vestibulum non ornare dui. Morbi eget lorem et ligula consectetur ullamcorper vel sollicitudin dui. Suspendisse potenti. Integer laoreet est est, ut tincidunt purus interdum id. Praesent non urna ante. Quisque ligula eros, pulvinar pulvinar pharetra at, semper id enim."
    }

]
const items2: Item[] = [
    {
        id:5,
        label:"Joint and Several Liability",
        descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultrices eros vel blandit egestas. Suspendisse purus libero, blandit vel ante non, tincidunt elementum justo. Vestibulum non ornare dui. Morbi eget lorem et ligula consectetur ullamcorper vel sollicitudin dui. Suspendisse potenti. Integer laoreet est est, ut tincidunt purus interdum id. Praesent non urna ante. Quisque ligula eros, pulvinar pulvinar pharetra at, semper id enim."
    },
    {
        id:6,
        label:"Colorado",
        descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultrices eros vel blandit egestas. Suspendisse purus libero, blandit vel ante non, tincidunt elementum justo. Vestibulum non ornare dui. Morbi eget lorem et ligula consectetur ullamcorper vel sollicitudin dui. Suspendisse potenti. Integer laoreet est est, ut tincidunt purus interdum id. Praesent non urna ante. Quisque ligula eros, pulvinar pulvinar pharetra at, semper id enim."
    },
    {
        id:7,
        label:"Joint and Several Liability",
        descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultrices eros vel blandit egestas. Suspendisse purus libero, blandit vel ante non, tincidunt elementum justo. Vestibulum non ornare dui. Morbi eget lorem et ligula consectetur ullamcorper vel sollicitudin dui. Suspendisse potenti. Integer laoreet est est, ut tincidunt purus interdum id. Praesent non urna ante. Quisque ligula eros, pulvinar pulvinar pharetra at, semper id enim."
    },
    {
        id:8,
        label:"ARO Creditor Rights",
        descripcion: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ultrices eros vel blandit egestas. Suspendisse purus libero, blandit vel ante non, tincidunt elementum justo. Vestibulum non ornare dui. Morbi eget lorem et ligula consectetur ullamcorper vel sollicitudin dui. Suspendisse potenti. Integer laoreet est est, ut tincidunt purus interdum id. Praesent non urna ante. Quisque ligula eros, pulvinar pulvinar pharetra at, semper id enim."
    }
]

function App() {
  return (
    <div className={"main"}>
        <BarraNav/>
        <div className={"contenedor1"}>
            <ListaInteractiva items ={items1}/>
            <ListaInteractiva items ={items2}/>
        </div>
    </div>
  )
}

export default App
