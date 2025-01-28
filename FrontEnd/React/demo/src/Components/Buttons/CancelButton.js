import { Button } from "react-bootstrap";
import '../Css/Save.css'
const Clear = () => {
    return (
        <>
            <Button id="button" variant='danger' onClick={() => {
                alert("Exit page ");
                document.querySelectorAll("#forms input").forEach(function (input) {
                    input.disabled = true;
                });
            }}>Cancel</Button>
            </>
    );
}
export default Clear;