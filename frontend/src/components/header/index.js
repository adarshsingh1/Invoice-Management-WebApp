import React from 'react'
import img1 from '../images/abc_products.png';
import img2 from '../images/hrc_logo.png';

export const Header = (props) => {
  return (
    <div style={{ margin: "1.5rem" }}>
      <img className="image1" src={img1} alt={"image1"} />
      <img className="image2" style={{ marginLeft: "18rem" }} src={img2} alt={"image2"} width="250" />
      <h2 style={{ color: "white" }}>Invoice List</h2>
    </div>
  )
}