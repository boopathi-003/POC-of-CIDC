import React, { ReactNode } from 'react'

interface LayoutProps {
  children: ReactNode;
}

const Userlayout = ({children}: LayoutProps) => {
  return (
    <>
    <div>User layout</div>
    {children}
    </>
  )
}

export default Userlayout