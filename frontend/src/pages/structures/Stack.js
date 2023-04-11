import { TextField } from "@mui/material";


function Stack() {

    return (
        <>
            <h1> Stacks </h1>
            <p>
                Stacks can be used to solve expressions. <br />
                Feel free to try it out bellow by inserting <br />
                mathmatical expressions using '+', '-', '\', <br />
                '*', '(', ')'.
            </p>
            <TextField
            variant="filled"
            >

            </TextField>
        </>
    );
}

export default Stack;