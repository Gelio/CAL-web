/*******************************************************************************
 * Copyright (c) 2021 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

import { makeStyles } from "@material-ui/core/styles";
import { PropertiesWebSocketContainer } from "@eclipse-sirius/sirius-components";
import { RightSiteProps } from "./RightSite.types";
import Typography from "@material-ui/core/Typography";

const useSiteStyles = makeStyles((theme) => ({
  site: {
    display: "grid",
    gridTemplateColumns: "minmax(0,1fr)",
    gridTemplateRows: "minmax(0,1fr)",
  },
  detailsHeading: {
    margin: theme.spacing(1, 1, 0),
  },
}));

export const RightSite = ({
  editingContextId,
  selection,
  setSelection,
  readOnly,
}: RightSiteProps) => {
  const classes = useSiteStyles();

  return (
    <div className={classes.site}>
      <div>
        <Typography variant="h6" className={classes.detailsHeading}>
          Details
        </Typography>

        <PropertiesWebSocketContainer
          editingContextId={editingContextId}
          selection={selection}
          setSelection={setSelection}
          readOnly={readOnly}
        />
      </div>
    </div>
  );
};
