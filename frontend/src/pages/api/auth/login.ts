import type { APIRoute } from "astro";
import { login as loginLogic } from "../../../utils/login";

const cookieName = import.meta.env.COOKIE_NAME || "_MicroBlog_Security_Login_";

export const POST: APIRoute = async ({ cookies, redirect, request }) => {
  const data = await request.formData();
  const login = data.get("login")?.toString() || "";
  const password = data.get("password")?.toString() || "";

  const result = await loginLogic({ login, password });

  let token = "none";
  let maxAge = 604800;

  if (result.success) {
    token = result.token!;
    cookies.set(cookieName, token, {
      path: "/",
      maxAge,
      secure: Boolean(import.meta.env.COOKIE_SECURE || false),
    });
    return redirect("/");
  }

  return redirect("/?login_error=true");
};