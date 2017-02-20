# replay.nvim

### Install steps

install the node-host neovim plugin (e.g with vim-plug with `Plug 'neovim/node-host'`)
*(consider putting this in a install : vim-plug part like fzf-vim does)*
run npm install inside the node-host folder once you have called `:PlugInstall`

then finally once your have run npm install for node-host run :UpdateRemotePlugins *when* replay.vim is loaded (otherwise it will not be on the runtimepath and will be missed)
I made this mistake because my vim-plug allows it only for clojure files - Plug 'michaelbruce/replay.nvim', { 'for' : 'clojure' }

### Dev notes

to reload the plugin fully
    - make changes & boot build to place them in rplugin/node
    - load nvim and :UpdateRemotePlugins
    - quit and relaunch nvim - commands should be accessible
