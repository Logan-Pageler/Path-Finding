import { Button, AppBar, Toolbar, MenuList, MenuItem, Menu, ClickAwayListener, Popper, Grow, Paper, makeStyles} from "@mui/material";
import { Box } from "@mui/system";
import React, { useRef } from "react";
import { useNavigate } from "react-router-dom";

const styles = makeStyles((theme) => ({
  styledPaper: {
    
  }
}))

function Navbar() {
  const navigate = useNavigate();
  const [open, setOpen] = React.useState(false);
  const anchorRef = useRef();

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = (event) => {
    if (
      anchorRef.current &&
      anchorRef.current.contains(event.target)
    ) {
      return;
    }

    setOpen(false);
  };


    return (
        <AppBar wrap='nowrap'>
            <Toolbar>
                <h1 style={{ flex: 1 }}>Sort-Wiki</h1>
                <Box>
                    <Button
                        onClick={() => { navigate("/");}}
                        sx={{ my: 2, color: 'white', display: 'block' }}
                    >
                        Home
                    </Button>
                    <Button
                        onClick={() => { navigate("/about");}}
                        sx={{ my: 2, color: 'white', display: 'block' }}
                    >
                        About
                    </Button>
                    
                      <Button
                          onClick={handleOpen}
                          sx={{ my: 2, color: 'white', display: 'block' }}
                          ref={anchorRef}
                      >
                          Sorters
                      </Button>
                      <Popper
                        open={open}
                        anchorEl={anchorRef.current}
                        role={undefined}
                        placement="bottom-start"
                      >

                        <ClickAwayListener onClickAway={handleClose}>
                          <Paper elevation={3} style={{backgroundcolor: 'black'}}>
                            <MenuList
                              autoFocusItem={open}
                              style={{color: 'black'}}
                            >
                              <MenuItem style={{color: 'black'}}>
                                  <Button
                                      onClick={() => { navigate("/quicksort");}}
                                      sx={{ my: 2, color: 'white', display: 'block' }}
                                  >
                                      Quick Sort
                                  </Button>
                              </MenuItem>
                              <MenuItem style={{color: 'black'}}>
                                  <Button
                                      onClick={() => { navigate("/bubblesort");}}
                                      sx={{ my: 2, color: 'white', display: 'block' }}
                                  >
                                      Bubble Sort
                                  </Button>
                              </MenuItem>
                            </MenuList>
                            </Paper>
                        </ClickAwayListener>
                    </Popper>
                </Box>
            </Toolbar>
        </AppBar>
    );
}

export default Navbar;