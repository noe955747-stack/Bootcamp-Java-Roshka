import React, { useState } from "react";
import type {objeto} from "../types/objeto";
import "./../styles/lista.css";

interface Props {
    items: objeto[];
}

const ListaInteractiva: React.FC<Props> = ({ items }) => {
    const [idExpandidos, setidExpandidos] = useState<number[]>([]);
    const [idSeleccionados, setidSeleccionados] = useState<number | null>(null);

    const toggleExpand = (id: number) => {
        setidExpandidos(prev =>
            prev.includes(id) ? prev.filter(e => e !== id) : [...prev, id]
        );
    };

    const handleSelect = (id: number) => {
        setidSeleccionados(id);
    };

    return (
        <div>
            {items.map(item => (
                <div key={item.id}>
                    <div
                        className={`item ${idSeleccionados === item.id ? "seleccionado" : ""}`}
                        onClick={() =>
                            item.children ? toggleExpand(item.id) : handleSelect(item.id)
                        }
                    >
                        {item.label}
                    </div>

                    {item.children && idExpandidos.includes(item.id) && (
                        <div className="subitems">
                            {item.children.map(sub => (
                                <div
                                    key={sub.id}
                                    className={`subitem ${idSeleccionados === sub.id ? "seleccionado" : ""}`}
                                    onClick={() => handleSelect(sub.id)}
                                >
                                    {sub.label}
                                </div>
                            ))}
                        </div>
                    )}
                </div>
            ))}
        </div>
    );
};

export default ListaInteractiva;