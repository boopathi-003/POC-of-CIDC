import React, { ReactNode } from 'react'

interface LayoutProps {
  children: ReactNode;
}

const Dashboardlayout = ({children}: LayoutProps) => {
  return (
    <>
    <div>Dashboard layout</div>
    {children}
    </>
  )
}

export default Dashboardlayout