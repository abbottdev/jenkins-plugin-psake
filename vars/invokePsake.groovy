
def call(String target, String label = '', String psakeFile = './psakefile.ps1') {
  String buildLabel = "Invoke-psake: ${target}"

  if (label != '') {
    buildLabel = label
  }

  pwsh script: "Invoke-psake ${psakeFile} ${target}; exit !(\$psake.build_success)", label: "${buildLabel}"
}