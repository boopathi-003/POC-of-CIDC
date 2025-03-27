import React, { ReactNode } from 'react'

interface LayoutProps {
  children: ReactNode;
}

const Homelayout = ({children}: LayoutProps) => {
  return (
    <>
    <div>Home layout</div>
    {children}
    </>
  )
}

export default Homelayout