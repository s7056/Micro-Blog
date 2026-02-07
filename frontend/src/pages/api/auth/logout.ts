import type { APIRoute } from "astro";

const cookieName = import.meta.env.COOKIE_NAME || "_MicroBlog_Security_Login_";

export const GET: APIRoute = async ({ cookies, redirect }) => {
  cookies.set(cookieName, "", {
    path: "/",
    maxAge: 0,
    secure: Boolean(import.meta.env.COOKIE_SECURE || false),
  });
  return redirect("/");
};