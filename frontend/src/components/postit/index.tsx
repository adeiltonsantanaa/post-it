import axios from 'axios';
import { useEffect, useState } from 'react';
import { postit } from '../../models';
import './style.css';

function Postit() {

    const [postit, setPostit] = useState<postit[]>([]);
    const [postit2, setPostit2] = useState("");

    useEffect(() => {
        axios.get('http://localhost:8080/postit/todos')
            .then(res => { setPostit(res.data.content) })
            .catch(err => { console.log(err) })
    }, []);


    return (
        <>
        {postit.map(postit => {return (
                        <div key={postit.id} className="postit">
                            <div className="postit-div-button">
                                <button className="postit-button-add">+</button>
                                <h6 className='postit-h6'>{postit.id}</h6>
                                <button className="postit-button-remove">x</button>
                            </div>
                            <hr></hr>
                            <textarea 
                            id="postit-textarea" 
                            maxLength={200}
                            onChange={(e) => {setPostit2(e.target.value)}}
                            >{postit.descricao}</textarea>
                        </div>
                )
            })
        }
        </>
    )
}

export default Postit;