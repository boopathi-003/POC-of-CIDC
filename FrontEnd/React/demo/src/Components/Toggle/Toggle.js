import menubar from '../Assets/menubar.png';
import hotdeck from '../Assets/Frame 629075.png';
import Sidebar from '../Sidebar/sidebar';
import Button from 'react-bootstrap/Button';
import Offcanvas from 'react-bootstrap/Offcanvas';
import { useState } from 'react';
import Header from '../Header/Header';
const Toggle = () => {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  return (
    // toggle

    <div className='row m-0 p-0'>
      <div className='col-6 p-0'>
        <>
          <Button variant="white border-end" onClick={handleShow}>
            <img className="" src={menubar} width={18} height={18} alt='hotdeck_image' />
          </Button>

          <Offcanvas className={"w-75"} show={show} onHide={handleClose}>
            <Offcanvas.Header closeButton>
              <Offcanvas.Title></Offcanvas.Title>
            </Offcanvas.Header>
            <Offcanvas.Body >
              <div className='w-75 ms-0'><Sidebar /></div>
            </Offcanvas.Body>
          </Offcanvas>
        </>
        <button className="btn  d-lg-none " type="button" data-bs-toggle="offcanvas"
          data-bs-target="#offcanvasResponsive" aria-controls="offcanvasResponsive">
          <img className="" src={hotdeck} width={30} height={30} alt='hotdeck_image' />
        </button>
      </div>

      {/* header */}
      <div className='col text-end '>
        <Header />
      </div>

    </div>
  );
}
export default Toggle;