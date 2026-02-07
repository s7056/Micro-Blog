import type { APIRoute } from "astro";
import { register as registerLogic } from "../../../utils/register";

export const POST: APIRoute = async ({ request, cookies, redirect }) => {
  const data = await request.formData();
  const login = data.get("login")?.toString() || "";
  const name = data.get("name")?.toString() || "";
  const email = data.get("email")?.toString() || "";
  const password = data.get("password")?.toString() || "";

  const result = await registerLogic({ login, name, email, password });
  if (result.success) {
    return redirect("/");
  }

   cookies.set("registerError", result.message, {
    path: "/register",
    maxAge: 60,
  });

  return redirect("/register");
};