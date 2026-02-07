const API = import.meta.env.API;

type LoginResponse = | { success: false; token: null } | { success: true; token: string };

export async function login({
    login,
    password,
}: {
    login: string;
    password: string;
}): Promise<LoginResponse> {
    try {
        const res = await fetch(`${API}/api/auth/login`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ login, password }),
        });

        if (!res.ok) return { success: false, token: null };

        const data = await res.json();
        if (!data.token) return { success: false, token: null };

        return { success: true, token: data.token };
    } catch (e) {
        console.error("Backend login error:", e);
        return { success: false, token: null };
    };
};