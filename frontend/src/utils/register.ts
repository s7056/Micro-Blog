const API = import.meta.env.API;

type RegisterResponse = | { success: false; message: string } | { success: true; message: string };

export async function register({
    login,
    name,
    email,
    password
} : {
    login: string;
    name: string;
    email: string;
    password: string;
}): Promise<RegisterResponse> {
    try {
        const res = await fetch(`${API}/api/auth/register`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ login, name, email, password }),
        });

        const result = await res.text();

        if (!res.ok) return { success: false, message: result || "Request failed" };
        return { success: true, message: result || "Registered successfully" };
    } catch (e) {
        console.error("Backend register error:", e);
        return { success: false, message: e instanceof Error ? e.message : String(e)};
    };
};