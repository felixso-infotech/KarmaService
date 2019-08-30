import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { KarmaSharedModule } from 'app/shared';
import {
  ChallengeComponent,
  ChallengeDetailComponent,
  ChallengeUpdateComponent,
  ChallengeDeletePopupComponent,
  ChallengeDeleteDialogComponent,
  challengeRoute,
  challengePopupRoute
} from './';

const ENTITY_STATES = [...challengeRoute, ...challengePopupRoute];

@NgModule({
  imports: [KarmaSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    ChallengeComponent,
    ChallengeDetailComponent,
    ChallengeUpdateComponent,
    ChallengeDeleteDialogComponent,
    ChallengeDeletePopupComponent
  ],
  entryComponents: [ChallengeComponent, ChallengeUpdateComponent, ChallengeDeleteDialogComponent, ChallengeDeletePopupComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class KarmaChallengeModule {}
