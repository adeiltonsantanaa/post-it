import './style.css';

function Postit() {

    return (
        <>
        <div className="postit">
        <div className="postit-div-button">
            <button className="postit-button-add">+</button>
            <button className="postit-button-remove">x</button>
        </div>
        <hr></hr>
        <textarea id="postit-textarea" maxLength={200}></textarea>
    </div>
</>
    )
  }
  
  export default Postit;