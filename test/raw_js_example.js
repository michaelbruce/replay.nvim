'use strict'

let beautify = require('cssbeautify')

plugin.commandSync('BeartifyCSS', ( nvim, cb ) => {
    nvim.getCurrentBuffer( ( err, buf ) => {
        buf.getLineSlice( 0, -1, true, true, ( err, lines ) => {
            let beautified = beautify( lines.join('\n') )
            buf.setLineSlice( 0, -1, true, true, beautified.split('\n'), cb )
        })
    })
})

plugin.commandSync('Pony', ( nvim, cb ) => {
  nvim.input('ihello', cb)
})
