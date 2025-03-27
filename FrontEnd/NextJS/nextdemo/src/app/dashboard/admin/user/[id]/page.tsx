import React from 'react'

interface PageProps {
  params: { id: string };
}

// Enable dynamic params (won't cause a 404 for unknown IDs)
export const dynamicParams = true;

// Generate static paths
export async function generateStaticParams() {
  const response = await fetch("https://api.vercel.app/blog");
  const pages: { id: string }[] = await response.json();

  return pages.map((page) => ({
    params: { id: page.id.toString() }, // ✅ Must wrap in "params"
  }));
}

// Page component
const Page: React.FC<PageProps> = async ({ params }) => {
  console.log("Params:", params);

  const response = await fetch(`https://api.vercel.app/blog/${params.id}`);
  const page = await response.json();

  return (
    <div>
      <h1>Dynamic Blogs</h1>
      <h2>{page.title}</h2>
      <p>{page.content}</p>
    </div>
  );
};

export default Page;
