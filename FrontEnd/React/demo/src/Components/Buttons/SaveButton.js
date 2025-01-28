import { Button } from "react-bootstrap";
import '../Css/Save.css';
import Modal from 'react-bootstrap/Modal';
import { useState } from "react";
const Save = () => {
    const [show, setshow] = useState(false);
    const handleClose = () => setshow(false);
    const handleShow = () => setshow(true);
    return (
        <>
            <Button variant="primary" id="button" onClick={handleShow}

            >Save</Button>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                   
                </Modal.Header>
                <Modal.Body >Saved Successfully!</Modal.Body>
                <Modal.Footer >
                    <Button onClick={handleClose}>Close</Button>
                    <Button onClick={(handleClose) => {
                        document.querySelectorAll("#forms input").forEach(function (input) {
                            input.disabled = true;
                        });
                    }
                    }>Ok</Button>
                </Modal.Footer>
            </Modal>

        </>
    );
}
export default Save;