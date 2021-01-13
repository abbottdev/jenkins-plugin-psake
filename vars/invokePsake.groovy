
def call(String target, String label = '', String psakeFile = './psakefile.ps1') {
  String buildLabel = target

  if (label != '') {
    buildLabel = target
  }
  pwsh script: "Invoke-psake ${psakeFile} ${target}; exit !(\$psake.build_success)", label: "${buildLabel}"
}