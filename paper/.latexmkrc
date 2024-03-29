# Specify the main file
@default_files = ('EE-dyplom.tex');
# Use xelatex
$pdf_mode = 5;

# Run `makeglossaries` as part of `latexmk`
# Source: https://tex.stackexchange.com/a/44316/261160

add_cus_dep('glo', 'gls', 0, 'run_makeglossaries');
add_cus_dep('acn', 'acr', 0, 'run_makeglossaries');

sub run_makeglossaries {
    my ($base_name, $path) = fileparse( $_[0] ); #handle -outdir param by splitting path and file, ...
    pushd $path; # ... cd-ing into folder first, then running makeglossaries ...

    if ( $silent ) {
        system "makeglossaries -q '$base_name'"; #unix
    }
    else {
        system "makeglossaries '$base_name'"; #unix
    };

    popd; # ... and cd-ing back again
}

push @generated_exts, 'glo', 'gls', 'glg';
push @generated_exts, 'acn', 'acr', 'alg';
$clean_ext .= ' %R.ist %R.xdy';
