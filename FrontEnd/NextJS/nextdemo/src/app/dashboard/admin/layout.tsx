import React, { ReactNode } from 'react'

interface LayoutProps {
  children: ReactNode;
}

const Adminlayout = ({children}: LayoutProps) => {
  return (
    <>
    <div>Admin layout</div>
    {children}
    </>
  )
}

export default Adminlayout