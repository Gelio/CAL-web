# CAL metamodel

This directory contains the metamodel of the CAL language.

## Opening the metamodel

To open the metamodel for inspection/editing, use [Obeo
Designer](https://www.obeodesigner.com/en/).

In Obeo Designer, do the following:

1. Click _File_ in the top bar
2. Select _Open Projects from File System..._
3. Browse to this directory.

   You should see Obeo Designer automatically detect the 4 projects
   (directories) in this directory.

4. Select projects to open.

   Select only those projects that begin with `CAL`.
   Deselect other projects (for example, Obeo Designer may offer to import the
   `model` project - the parent directory. It does not add any functionality
   and may make editing confusing, so it is discouraged to open it).

At this point, Obeo Designer may offer to use the `maven2Nature` Eclipse
extension. It is not necessary to work with the metamodel. The popup can be
safely ignored.

This project nature suggestion appears because when editing the project with an
IDE that works with Maven projects (e.g. [VSCode Maven
extension](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven)
or [Neovim Eclipse extension](https://github.com/mfussenegger/nvim-jdtls)), the
IDE automatically adds the `maven2Nature` to `.project` files for all projects
it finds.

## Editing Java files in the metamodel

Use Obeo Designer to edit Java files in the metamodel.

Using other IDEs to edit the Java files will show errors when resolving
dependencies. That is because metamodel dependencies are defined in OSGi
`META-INF/MANIFEST.MF`, which non-Eclipse IDEs cannot resolve.

See [this GitHub
comment](https://github.com/eclipse-sirius/sirius-web/issues/36#issuecomment-938570106)
for more information.

<!-- vim: set tw=80: -->
