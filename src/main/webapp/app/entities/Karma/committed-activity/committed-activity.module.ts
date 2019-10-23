import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { KarmaSharedModule } from 'app/shared';
import {
  CommittedActivityComponent,
  CommittedActivityDetailComponent,
  CommittedActivityUpdateComponent,
  CommittedActivityDeletePopupComponent,
  CommittedActivityDeleteDialogComponent,
  committedActivityRoute,
  committedActivityPopupRoute
} from './';

const ENTITY_STATES = [...committedActivityRoute, ...committedActivityPopupRoute];

@NgModule({
  imports: [KarmaSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    CommittedActivityComponent,
    CommittedActivityDetailComponent,
    CommittedActivityUpdateComponent,
    CommittedActivityDeleteDialogComponent,
    CommittedActivityDeletePopupComponent
  ],
  entryComponents: [
    CommittedActivityComponent,
    CommittedActivityUpdateComponent,
    CommittedActivityDeleteDialogComponent,
    CommittedActivityDeletePopupComponent
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class KarmaCommittedActivityModule {}
