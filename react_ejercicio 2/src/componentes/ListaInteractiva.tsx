import React, { useState } from "react";
import type { Item } from "../types/objeto";
import "./../stylesheets/lista.css";

interface Props {
    items: Item[];
}

const ListaInteractiva: React.FC<Props> = ({ items }) => {
    const [idExpandidos, setidExpandidos] = useState<number | null>(null);

    const toggleExpand = (id: number) => {
        setidExpandidos(prev => (prev === id ? null : id));
    };

    return (
        <div className="menu-container">
            {items.map(item => (
                <div key={item.id} className="item-container">
                    <div className="item" onClick={() => toggleExpand(item.id)}>
                        {item.label}
                    </div>

                    {idExpandidos === item.id && (
                        <div className="descripcion">
                            <p>{item.descripcion}</p>
                        </div>
                    )}
                </div>
            ))}
        </div>
    );
};


export default ListaInteractiva;