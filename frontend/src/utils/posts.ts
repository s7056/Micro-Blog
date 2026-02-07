const API = import.meta.env.API;

const authHeader = () => ({
    Authorization: `Bearer ${localStorage.getItem("token")}`,
});

export async function getPosts() {
    const res = await fetch(`${API}/api/posts`, {
        headers: {
        ...authHeader(),
        },
    });

    if (!res.ok) throw new Error("Cannot load posts");

    return res.json();
};

export async function addPost(data: {
    content: string;
    privatePost: boolean;
}) {
    const res = await fetch(`${API}/api/posts`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            ...authHeader(),
        },
        body: JSON.stringify(data),
    });

    if (!res.ok) throw new Error("Cannot add post");

    return res.json();
};