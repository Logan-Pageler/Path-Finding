import { Button, AppBar, Toolbar, MenuList, MenuItem, ClickAwayListener, Popper, Paper, Stack} from "@mui/material";
import React, { useRef } from "react";
import { useNavigate } from "react-router-dom";
import "./Navbar.css"



function Navbar() {
    const navigate = useNavigate();
    const [open, setOpen] = React.useState(false);
    const [open2, setOpen2] = React.useState(false);
    const anchorRef = useRef();
    const anchorRef2 = useRef();

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

    const handleOpen2 = () => {
      setOpen2(true);
    };

    const handleClose2 = (event) => {
        if (
            anchorRef2.current &&
            anchorRef2.current.contains(event.target)
        ) {
            return;
        }

        setOpen2(false);
    };


    return (
        <AppBar wrap='nowrap'>
            <Toolbar>
                <h1 style={{ flex: 1 }}>Sort-Wiki</h1>
                <Stack direction="row" spacing={2}>
                    <Button
                        onClick={() => { navigate("/");}}
                        sx={{ my: 2, color: 'white', display: 'block' }}
                    >
                        Home
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
                          <Paper elevation={3} className="menu-background">
                            <MenuList
                              autoFocusItem={open}
                            >
                              <MenuItem 
                                      onClick={() => { navigate("/quicksort");}}
                                      sx={{ my: 2, color: 'white', display: 'block' }}
                                    >
                                      Quick Sort
                              </MenuItem>
                              <MenuItem
                                      onClick={() => { navigate("/bubblesort");}}
                                      sx={{ my: 2, color: 'white', display: 'block' }}
                                  >
                                      Bubble Sort
                              </MenuItem>
                              <MenuItem
                                      onClick={() => { navigate("/selectionsort");}}
                                      sx={{ my: 2, color: 'white', display: 'block' }}
                                  >
                                      Selection Sort
                              </MenuItem>
                              <MenuItem 
                                      onClick={() => { navigate("/insertionsort");}}
                                      sx={{ my: 2, color: 'white', display: 'block' }}
                                  >
                                      Insertion Sort
                              </MenuItem>
                              <MenuItem 
                                      onClick={() => { navigate("/heapsort");}}
                                      sx={{ my: 2, color: 'white', display: 'block' }}
                                  >
                                      Heap Sort
                              </MenuItem>
                              <MenuItem 
                                      onClick={() => { navigate("/shellsort");}}
                                      sx={{ my: 2, color: 'white', display: 'block' }}
                                  >
                                      Shell Sort
                              </MenuItem>
                            </MenuList>
                            </Paper>
                        </ClickAwayListener>
                    </Popper>
                    <Button
                          onClick={handleOpen2}
                          sx={{ my: 2, color: 'white', display: 'block' }}
                          ref={anchorRef2}
                      >
                          structures
                      </Button>
                      <Popper
                        open={open2}
                        anchorEl={anchorRef2.current}
                        role={undefined}
                        placement="bottom-start"
                      >
                        <ClickAwayListener onClickAway={handleClose2}>
                          <Paper elevation={3} className="menu-background">
                            <MenuList
                              autoFocusItem={open2}
                            >
                              <MenuItem 
                                      onClick={() => { navigate("/stack");}}
                                      sx={{ my: 2, color: 'white', display: 'block' }}
                                  >
                                      Stack
                              </MenuItem>
                            </MenuList>
                            </Paper>
                        </ClickAwayListener>
                    </Popper>
                </Stack>
            </Toolbar>
        </AppBar>
    );
}

export default Navbar;