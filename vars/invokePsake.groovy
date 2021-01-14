
def call(String target, String label = '', String psakeFile = './psakefile.ps1', String workingDirectory = './') {
  String buildLabel = "Invoke-psake: ${target}"

  if (label != '') {
    buildLabel = label
  }

  if (psakeFile == '') {
    psakeFile = './psakefile.ps1'
  }

  dir(workingDirectory) {
    pwsh script: "Invoke-psake ${psakeFile} ${target}; exit !(\$psake.build_success)", label: "${buildLabel}"
  }
}