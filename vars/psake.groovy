
def call(Map config) {
    String label = config.target
    String psakeFile =  './psakefile.ps1'

    if (config.label != '') {
        label = config.label
    }

    if (config.psakeFile != '') {
        psakeFile = config.psakeFile
    }

    pwsh script: "Invoke-psake ${psakeFile} ${target}; exit !(\$psake.build_success)", label: "${label}"
}
